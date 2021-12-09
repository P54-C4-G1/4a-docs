const unidadHabitacionalResolver = {
    Query: {
        unidadHabitacionalByidunidad: async(_, { idunidad }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.unidadHabitacionalByidunidad(idunidad)
            else
                return null
        }
    },
    Mutation: {
        createunidadHabitacional: async(_, { unidadHabitacional }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return dataSources.generalAPI.createunidadHabitacional(unidadHabitacional)
            else
                return null
        }
    }
};

module.exports = unidadHabitacionalResolver;