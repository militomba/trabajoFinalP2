import dayjs from 'dayjs';

export interface IOrdenes {
  id?: number;
  cliente?: number | null;
  accionID?: number | null;
  accion?: string | null;
  operacion?: string | null;
  cantidadAcciones?: number | null;
  fechaOperacion?: string | null;
  modo?: string | null;
  operacionExitosa?: boolean | null;
  operacionObservaciones?: string | null;
  ejecutada?: boolean | null;
  reportada?: boolean | null;
}

export const defaultValue: Readonly<IOrdenes> = {
  operacionExitosa: false,
  ejecutada: false,
  reportada: false,
};
