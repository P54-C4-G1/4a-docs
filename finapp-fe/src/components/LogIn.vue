<template>

    <div class="logIn_user">
        
        <div class="sidebar">
            <h1 class="welcome">¡Bienvenido!</h1>
            <img class="logo" :src="require('../assets/FinApp.png')" alt="">
            <h1 class="appname">FinApp</h1>
        </div>

        <div class="container_logIn_user">
            <h2 class="headlogin">Iniciar sesión</h2>

            <form v-on:submit.prevent="processLogInUser" >
                <p>Usuario</p>
                <input type="text" v-model="user.username" placeholder="Usuario">
                <br>
                <p>Contraseña</p>
                <input type="password" v-model="user.password" placeholder="Contraseña">
                <br>
                <button type="submit">Entrar</button>
                <p>¿No tienes cuenta? ¡Registrate!</p>
                <button v-on:click="loadSignUp">Registrarse</button>
            </form>
        </div>
        
    </div>

</template>




<script>
import gql from "graphql-tag";

export default {
        name: "LogIn",

    data: function() {
        return {
            user: {
                username: "",
                password: "",
            },
        };
    },

    methods: {
        processLogInUser: async function() {
            await this.$apollo
                .mutate({
                    mutation: gql`
                        mutation($credentials: CredentialsInput!) {
                            logIn(credentials: $credentials) {
                                refresh
                                access
                            }
                        }
                    `,
                    variables: {
                        credentials: this.user,
                    },
                })
                .then((result) => {
                    let dataLogIn = {
                        username: this.user.username,
                        token_access: result.data.logIn.access,
                        token_refresh: result.data.logIn.refresh,
                    };

                    this.$emit("completedLogIn", dataLogIn);
                })
                .catch((error) => {
                    alert("ERROR 401: Credenciales Incorrectas.");
                });
        },

        loadSignUp: function(){
        this.$router.push({name: "signUp"})
        },

    },
}
</script>







<style>

    .logIn_user{
        margin: 0px;
        padding: 0px;
        height: 100%;
        width: 100%;

        display: flex;
        justify-content: right;
        align-items: center;
    }

    .container_logIn_user {
        border: 0px solid  #283747;
        border-radius: 10px;
        width: 45%;
        height: 100%;
        
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .logIn_user h2{
        color: #283747;

    }

    .logIn_user form{
        width: 70%;
        
    }

    .logIn_user input{
        height: 40px;
        width: 100%;

        box-sizing: border-box;
        padding: 10px 20px;
        margin: 5px 0;

        border: 1px solid #283747;
    }

    .logIn_user button{
        width: 100%;
        height: 40px;

        color: #28313a;
        background: #aeb3b9;
        border: 1px solid #E5E7E9;

        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px 0;
    }

    .logIn_user button:hover{
        color: #28313a;
        background: #75a8db;
        border: 1px solid #283747;
    }

</style>