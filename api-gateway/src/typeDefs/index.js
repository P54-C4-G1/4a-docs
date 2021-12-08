//Se llama al typedef (esquema) de cada submodulo
const unidadHabitacionalTypeDefs = require('./unidadHabitacional_type_defs');
const categoriaTypeDefs = require('./categoria_type_defs');
const integranteTypeDefs = require('./integrante_type_defs');
const gastoTypeDefs = require('./gasto_type_defs');
const movimientoTypeDefs = require('./movimiento_type_defs');
const authTypeDefs = require('./auth_type_defs');

//Se unen
const schemasArrays = [authTypeDefs, unidadHabitacionalTypeDefs, categoriaTypeDefs, integranteTypeDefs, gastoTypeDefs, movimientoTypeDefs];

//Se exportan
module.exports = schemasArrays;