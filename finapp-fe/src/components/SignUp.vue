<template>
    <div class="signUp_user">
        <div class="container_signUp_user">
            <h2>Registrarse</h2>

            <form v-on:submit.prevent="processSignUp" >
                <input type="text" v-model="user.username" placeholder="Usuario">
                <br>

                <input type="password" v-model="user.password" placeholder="Contraseña">
                <br>

                <input type="text" v-model="user.name" placeholder="Nombre">
                <br>

                <input type="email" v-model="user.email" placeholder="Correo">
                <br>

                <input type="date" v-model="user.fecnac" placeholder="Fecha Nacimiento">
                <br>

                <button type="submit">Registrarse</button>
                <button v-on:click="loadLogIn">Cancelar</button>
            </form>
        </div>
    </div>
</template>





<script>
import gql from "graphql-tag";

export default {
    name: "SignUp",

    data: function() {
        return {
        user: {
            username: "",
            password: "",
            name: "",
            email: "",
            fecnac: "",
        },
        };
    },

 methods: {
    processSignUp: async function() {
    await this.$apollo
        .mutate({
            mutation: gql`
                mutation($userInput: SignUpInput!) {
                    signUpUser(userInput: $userInput) {
                        refresh
                        access
                    }
                }
            `,
            variables: {
                userInput: this.user,
            },
        })
        .then((result) => {
            let dataLogIn = {
                username: this.user.username,
                token_access: result.data.signUpUser.access,
                token_refresh: result.data.signUpUser.refresh,
        };

            this.$emit("completedSignUp", dataLogIn);
        })
        .catch((error) => {
            alert("ERROR: Fallo en el registro.");
        });
    },
    loadLogIn: function(){
      this.$router.push({name: "logIn"})
    },
 },
}
</script>





<style>

    .signUp_user{
        margin: 0;
        padding: 0%;
        height: 100%;
        width: 100%;
    
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container_signUp_user {
        border: 0px solid  #283747;
        border-radius: 10px;
        width: 50%;
        height: 60%;
        
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .signUp_user h2{
        color: #283747;

    }

    .signUp_user form{
        width: 70%;
        
    }

    .signUp_user input{
        height: 40px;
        width: 100%;

        box-sizing: border-box;
        padding: 10px 20px;
        margin: 5px 0;

        border: 1px solid #283747;
    }

    .signUp_user button{
        width: 100%;
        height: 40px;

        color: #28313a;
        background: #aeb3b9;
        border: 1px solid #E5E7E9;

        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px 0 25px 0;
    }

    .signUp_user button:hover{
        color: #28313a;
        background: #75a8db;
        border: 1px solid #283747;
    }

</style>