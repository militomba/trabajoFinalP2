package ar.edu.um.programacion2.procesador.service;

import ar.edu.um.programacion2.procesador.domain.Ordenes;
import ar.edu.um.programacion2.procesador.repository.OrdenesRepository;
import ar.edu.um.programacion2.procesador.service.dto.OrdenDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ObterenOrdenes {

    private final OrdenesRepository ordenesRepository;
    private final RestTemplate restTemplate;

    private final String token =
        "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtaWxpdG9tYmExIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcyOTE3OTQwOH0.JFOOJCd7_DuIAyIDgf6DGYiaWUMGAz465guJQMaIwyCUQJyWnkUJrpC6vrxP--g_j1pJAfYD21DuXXhcyAlRYQ";

    public ObterenOrdenes(OrdenesRepository ordenesRepository, RestTemplate restTemplate) {
        this.ordenesRepository = ordenesRepository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 60000)
    private void obtenerOrdenesServicioProfe() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<OrdenDTO[]> response = restTemplate.exchange(
            "http://192.168.194.254:8000/api/ordenes/ordenes",
            HttpMethod.GET,
            entity,
            OrdenDTO[].class
        );
        OrdenDTO[] ordenDTOs = response.getBody();
        obtenerOrdenes(ordenDTOs);
    }

    public void obtenerOrdenes(OrdenDTO[] ordenDTOs) {
        for (OrdenDTO ordenDTO : ordenDTOs) {
            if (!ordenesRepository.existsById(ordenDTO.getId())) {
                Ordenes ordenNueva = new Ordenes();
                ordenNueva.setId(ordenDTO.getId());
                ordenNueva.setCliente(ordenDTO.getCliente());
                ordenNueva.setAccion(ordenDTO.getAccion());
                ordenNueva.setOperacion(ordenDTO.getOperacion());
                ordenNueva.setCantidadAcciones(ordenDTO.getCantidadAcciones());
                ordenNueva.setFechaOperacion(ordenDTO.getFechaOperacion());
                ordenNueva.setModo(ordenDTO.getModo());
                ordenNueva.setOperacionExitosa(ordenDTO.getOperacionExitosa());
                ordenNueva.setOperacionObservaciones(ordenDTO.getOperacionObservaciones());
                ordenNueva.setEjecutada(ordenDTO.getEjecutada());
                ordenNueva.setReportada(ordenDTO.getReportada());

                ordenesRepository.save(ordenNueva);
            }
        }
    }
}
