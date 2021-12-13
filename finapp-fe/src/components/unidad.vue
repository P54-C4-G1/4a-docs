
<template>

    <div id="Unidad" class="Unidad">
        <div class="container_Unidad">
            <h2>Unidades Habitacionales</h2>
            <div class="container-table">
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Usuario</th>
                    </tr>

                    <tr v-for="transaction in transactionByUsername" :key="transaction.id">
                        <td>{{ transaction.date.substring(0, 10) }}</td>
                        <td>{{ transaction.date.substring(11, 19) }}</td>
                        <td>{{ transaction.usernameOrigin }}</td>
                        <td>{{ transaction.usernameDestiny }}</td>
                        <td>${{ transaction.value }} COP</td>
                    </tr>
                </table>
            </div>

            <h2>Nueva Unidad Habitacional</h2>

            <form v-on:submit.prevent="processUnidad">
                <input
                    type="text"
                    v-model="createUnidad.usernameDestiny"
                    placeholder="Nombre Unidad"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="cantidad"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="Valor"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="Valor"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="Valor"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="Valor"
                />
                <br />
                <input
                    type="number"
                    v-model="createUnidad.value"
                    placeholder="Valor"
                />
                <br />
                 <input
                    type="text"
                    v-model="createUnidad.usernameDestiny"
                    placeholder="Persona 1"
                />
                <br /> <input
                    type="text"
                    v-model="createUnidad.usernameDestiny"
                    placeholder="Persona 2"
                />
                <br /> <input
                    type="text"
                    v-model="createUnidad.usernameDestiny"
                    placeholder="Persona 3"
                />
                <br />

                <button type="submit"><strong> Crear Unidad</strong></button>
            </form>
        </div>
    </div>

</template>

<script>
import gql from "graphql-tag";

export default {
    name: "Unidad",

    data: function() {
        return {
            createUnidad: {
                usernameOrigin: localStorage.getItem("username"),
                usernameDestiny: "",
                value: "",
            },
        };
    },

    methods: {
        processUnidad: async function() {

            if (localStorage.getItem("token_access") === null ||
                    localStorage.getItem("token_refresh") === null ) {
                this.$emit("logOut");
                return;
            }

            localStorage.setItem("token_access", "");

            await this.$apollo
                .mutate({
                    mutation: gql`
                        mutation ($refresh: String!) {
                            refreshToken(refresh: $refresh) {
                                access
                            }
                        }
                    `,
                    variables: {
                        refresh: localStorage.getItem("token_refresh"),
                    },
                })
                .then((result) => {
                    localStorage.setItem("token_access", result.data.refreshToken.access);
                })
                .catch((error) => {
                    this.$emit("logOut");
                    return;
                });

            await this.$apollo
                .mutate({
                    mutation: gql`
                        mutation($Unidad: UnidadInput!) {
                            createUnidad(Unidad: $Unidad) {
                                date
                                id
                                usernameDestiny
                                usernameOrigin
                                value
                            }
                        }
                    `,
                    variables: {
                        Unidad: this.createUnidad,
                    },
                })
            .then((result) => {
                alert("Transacción Realizada de Manera Correcta, Revise Historial");
            })
            .catch((error) => {
                alert("Saldo Insuficiente o Destino Incorrecto");
            });
        },
    },
};
</script>

<style>

.Unidad {
    margin: 0;
    padding: 0%;
    height: 100%;
    width: 100%;

    display: flex;
    justify-content: center;
    align-items: center;
}

.container_Unidad {
    border: 1px solid #283747;
    border-radius: 10px;
    width: 65%;
    height: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.Unidad h2 {
    color: #283747;
}

.Unidad h3 {
    color: #283747;
}

.Unidad form {
    width: 50%;
}

.Unidad input {
    height: 40px;
    width: 100%;

    box-sizing: border-box;
    padding: 10px 20px;
    margin: 5px 0;

    border: 1px solid #283747;
}

.Unidad button {
    width: 100%;
    height: 40px;

    color: #28313a;
    background: #aeb3b9;
    border: 1px solid #E5E7E9;

    border-radius: 5px;
    padding: 10px 25px;
    margin: 5px 0;
}

.Unidad button:hover {
    color: #28313a;
    background: #75a8db;
    border: 1px solid #283747;
}

</style>