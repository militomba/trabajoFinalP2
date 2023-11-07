import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IOrdenes } from 'app/shared/model/ordenes.model';
import { getEntity, updateEntity, createEntity, reset } from './ordenes.reducer';

export const OrdenesUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const ordenesEntity = useAppSelector(state => state.ordenes.entity);
  const loading = useAppSelector(state => state.ordenes.loading);
  const updating = useAppSelector(state => state.ordenes.updating);
  const updateSuccess = useAppSelector(state => state.ordenes.updateSuccess);

  const handleClose = () => {
    navigate('/ordenes' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.fechaOperacion = convertDateTimeToServer(values.fechaOperacion);

    const entity = {
      ...ordenesEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          fechaOperacion: displayDefaultDateTime(),
        }
      : {
          ...ordenesEntity,
          fechaOperacion: convertDateTimeFromServer(ordenesEntity.fechaOperacion),
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="procesadorOrdenesApp.ordenes.home.createOrEditLabel" data-cy="OrdenesCreateUpdateHeading">
            <Translate contentKey="procesadorOrdenesApp.ordenes.home.createOrEditLabel">Create or edit a Ordenes</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="ordenes-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.cliente')}
                id="ordenes-cliente"
                name="cliente"
                data-cy="cliente"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.accionID')}
                id="ordenes-accionID"
                name="accionID"
                data-cy="accionID"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.accion')}
                id="ordenes-accion"
                name="accion"
                data-cy="accion"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.operacion')}
                id="ordenes-operacion"
                name="operacion"
                data-cy="operacion"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.cantidadAcciones')}
                id="ordenes-cantidadAcciones"
                name="cantidadAcciones"
                data-cy="cantidadAcciones"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.fechaOperacion')}
                id="ordenes-fechaOperacion"
                name="fechaOperacion"
                data-cy="fechaOperacion"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.modo')}
                id="ordenes-modo"
                name="modo"
                data-cy="modo"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.operacionExitosa')}
                id="ordenes-operacionExitosa"
                name="operacionExitosa"
                data-cy="operacionExitosa"
                check
                type="checkbox"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.operacionObservaciones')}
                id="ordenes-operacionObservaciones"
                name="operacionObservaciones"
                data-cy="operacionObservaciones"
                type="text"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.ejecutada')}
                id="ordenes-ejecutada"
                name="ejecutada"
                data-cy="ejecutada"
                check
                type="checkbox"
              />
              <ValidatedField
                label={translate('procesadorOrdenesApp.ordenes.reportada')}
                id="ordenes-reportada"
                name="reportada"
                data-cy="reportada"
                check
                type="checkbox"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/ordenes" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default OrdenesUpdate;
