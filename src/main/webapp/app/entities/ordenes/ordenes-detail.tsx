import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './ordenes.reducer';

export const OrdenesDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const ordenesEntity = useAppSelector(state => state.ordenes.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="ordenesDetailsHeading">
          <Translate contentKey="procesadorOrdenesApp.ordenes.detail.title">Ordenes</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.id}</dd>
          <dt>
            <span id="cliente">
              <Translate contentKey="procesadorOrdenesApp.ordenes.cliente">Cliente</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.cliente}</dd>
          <dt>
            <span id="accionID">
              <Translate contentKey="procesadorOrdenesApp.ordenes.accionID">Accion ID</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.accionID}</dd>
          <dt>
            <span id="accion">
              <Translate contentKey="procesadorOrdenesApp.ordenes.accion">Accion</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.accion}</dd>
          <dt>
            <span id="operacion">
              <Translate contentKey="procesadorOrdenesApp.ordenes.operacion">Operacion</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.operacion}</dd>
          <dt>
            <span id="cantidadAcciones">
              <Translate contentKey="procesadorOrdenesApp.ordenes.cantidadAcciones">Cantidad Acciones</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.cantidadAcciones}</dd>
          <dt>
            <span id="fechaOperacion">
              <Translate contentKey="procesadorOrdenesApp.ordenes.fechaOperacion">Fecha Operacion</Translate>
            </span>
          </dt>
          <dd>
            {ordenesEntity.fechaOperacion ? <TextFormat value={ordenesEntity.fechaOperacion} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="modo">
              <Translate contentKey="procesadorOrdenesApp.ordenes.modo">Modo</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.modo}</dd>
          <dt>
            <span id="operacionExitosa">
              <Translate contentKey="procesadorOrdenesApp.ordenes.operacionExitosa">Operacion Exitosa</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.operacionExitosa ? 'true' : 'false'}</dd>
          <dt>
            <span id="operacionObservaciones">
              <Translate contentKey="procesadorOrdenesApp.ordenes.operacionObservaciones">Operacion Observaciones</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.operacionObservaciones}</dd>
          <dt>
            <span id="ejecutada">
              <Translate contentKey="procesadorOrdenesApp.ordenes.ejecutada">Ejecutada</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.ejecutada ? 'true' : 'false'}</dd>
          <dt>
            <span id="reportada">
              <Translate contentKey="procesadorOrdenesApp.ordenes.reportada">Reportada</Translate>
            </span>
          </dt>
          <dd>{ordenesEntity.reportada ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/ordenes" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/ordenes/${ordenesEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default OrdenesDetail;
