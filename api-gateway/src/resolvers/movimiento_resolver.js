const movimientoResolver = {
    Query: {
        movimientoByidmovimiento: async(_, { idmovimiento }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.movimientoByidmovimiento(idmovimiento)
            else
                return null
        },

        movimientoByidusuario: async(_, { idusuario }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.movimientoByidusuario(idusuario)
            else
                return null
        }
    },
    Mutation: {
        createMovimiento: async(_, { movimiento }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.createMovimiento(movimiento)
            else
                return null
        }
    }
};

module.exports = movimientoResolver;