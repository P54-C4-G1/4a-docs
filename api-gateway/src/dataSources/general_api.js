const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class GeneralAPI extends RESTDataSource {

    constructor() {
        super();
        this.baseURL = serverConfig.general_api_url;
    }

    async createunidadHabitacional(unidadhabitacional) {
        unidadhabitacional = new Object(JSON.parse(JSON.stringify(unidadhabitacional)));
        return await this.post('/unidades', unidadHabitacional);
    }

    async createCategoria(categoria) {
        categoria = new Object(JSON.parse(JSON.stringify(categoria)));
        return await this.post('/categorias', categoria);
    }

    async createIntegrante(integrante) {
        integrante = new Object(JSON.parse(JSON.stringify(integrante)));
        return await this.post('/integrantes', integrante);
    }

    async createGasto(gasto) {
        gasto = new Object(JSON.parse(JSON.stringify(gasto)));
        return await this.post('/gastos', gasto);
    }

    async createMovimiento(movimiento) {
        movimiento = new Object(JSON.parse(JSON.stringify(movimiento)));
        return await this.post('/movimientos', movimiento);
    }

    async unidadHabitacionalByidunidad(idunidad) {
        return await this.get(`/unidades/${idunidad}`);
    }

    async unidadHabitacionalByidusuario(idusuario) {
        return await this.get(`/unidades/integrante/${idusuario}`);
    }

    async categoriaByidcategoria(idcategoria) {
        return await this.get(`/categorias/${idcategoria}`);
    }

    async categorias() {
        return await this.get(`/categorias/`);
    }

    async integranteByidusuario(idusuario) {
        return await this.get(`/integrantes/${idusuario}`);
    }

    async integranteByidunidad(idunidad) {
        return await this.get(`/integrantes/unidad/${idunidad}`);
    }

    async gastoByidgasto(idgasto) {
        return await this.get(`/gastos/${idgasto}`);
    }

    async gastoByidunidad(idunidad) {
        return await this.get(`/gastos/unidad/${idunidad}`);
    }

    async gastoByidcategoria(idcategoria) {
        return await this.get(`/gastos/categorias/${idcategoria}`);
    }

    async movimientoByidmovimiento(idmovimiento) {
        return await this.get(`/movimientos/${idmovimiento}`);
    }

    async movimientoByidusuario(idusuario) {
        return await this.get(`/movimientos/integrante/${idusuario}`);
    }
}

module.exports = GeneralAPI;
