const categoriaResolver = {
    Query: {
        categoriaByidcategoria: async(_, { idcategoria }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.categoriaByidcategoria(idcategoria)
            else
                return null
        }
    },
    Mutation: {
        createCategoria: async(_, { categoria }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.createCategoria(categoria)
            else
                return null
        }
    }
};

module.exports = categoriaResolver;