const integranteResolver = {
    Query: {
        integranteByidusuario: async(_, { idusuario }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.integranteByidusuario(idusuario)
            else
                return null
        },

        integranteByidunidad: async(_, { idunidad }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.integranteByidunidad(idunidad)
            else
                return null
        }
    },
    Mutation: {
        createIntegrante: async(_, { integrante }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.createIntegrante(integrante)
            else
                return null
        }
    }
};

module.exports = integranteResolver;