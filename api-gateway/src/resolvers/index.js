const unidadHabitacionalResolver = require('./unidadHabitacional_resolver');
const categoriaResolver = require('./categoria_resolver');
const integranteResolver = require('./integrante_resolver');
const gastoResolver = require('./gasto_resolver');
const movimientoResolver = require('./movimiento_resolver');
const authResolver = require('./auth_resolver');

const lodash = require('lodash');

const resolvers = lodash.merge(unidadHabitacionalResolver, categoriaResolver, integranteResolver, gastoResolver, movimientoResolver, authResolver);

module.exports = resolvers;