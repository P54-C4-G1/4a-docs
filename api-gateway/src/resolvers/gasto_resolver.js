const gastoResolver = {
    Query: {
        gastoByidgasto: async(_, { idgasto }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.gastoByidgasto(idgasto)
            else
                return null
        },

        gastoByidunidad: async(_, { idunidad }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.gastoByidunidad(idunidad)
            else
                return null
        },

        gastoByidcategoria: async(_, { idcategoria }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.gastoByidcategoria(idcategoria)
            else
                return null
        }
    },
    Mutation: {
        createGasto: async(_, { gasto }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.createGasto(gasto)
            else
                return null
        }
    }
};

module.exports = gastoResolver;