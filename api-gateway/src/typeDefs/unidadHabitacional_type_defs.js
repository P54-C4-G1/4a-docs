const { gql } = require('apollo-server');

const unidadHabitacionalTypeDefs = gql `
    type unidadHabitacional {
        idunidad: String!
        idusuario: String!
        nombre: String!
    }

    input unidadHabitacionalInput {
        idunidad: String!
        idusuario: String!
        nombre: String!
    }

    extend type Query {
        unidadHabitacionalByidunidad(idunidad: String!): [unidadHabitacional]
    }

    extend type Mutation {
        createunidadHabitacional(unidadHabitacional: unidadHabitacionalInput!): unidadHabitacional
    }
`;

module.exports = unidadHabitacionalTypeDefs;