<template>
    <div class="information">

        

        <div class = "imagen">
                <img :src="require('../assets/finanzas.png')" alt="" >
        </div>

        <div class="details">

            <h1>
                ¡Hola
                <span>{{ userDetailById.name }}</span>!
            </h1>
            
            <nav>
                <button v-on:click="loadAccount"> <h2>LISTA DE PROYECTOS</h2> </button>
            </nav>
            <nav>
                <button v-on:click="loadAccount"><h3>  GASTOS PERSONALES </h3> </button>
            </nav>
            <nav>
                <button v-on:click="loadTransaction"> <h2>CREAR UNIDAD HABITACIONAL</h2> </button>
            </nav>
        
        </div>
       
    </div>
    
</template>



<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";

export default {
    name: "Home",

    data: function () {
        return {
            userId: jwt_decode(localStorage.getItem("token_refresh")).user_id,
            userDetailById: {
                username: "",
                name: "",
                email: "",
            },
        };
    },
    apollo: {
        userDetailById: {
            query: gql`
                query ($userId: Int!) {
                    userDetailById(userId: $userId) {
                        username
                        name
                        email
                    }
                }
            `,
            variables() {
                return {
                    userId: this.userId,
                };
            }
        },
    },

    methods:{

        loadAccount: function () {
        this.$router.push({ name: "account" });
        },

        loadTransaction: function(){
        this.$router.push({ name: "transaction" });
        }
    }
};
</script>



<style>

.information {
    margin: auto;
    padding: auto;
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
}

.information h1 {
    font-size: 60px;
    color: #283747;
    text-align: center;
}

.information span {
    color: #283747;
    font-weight: bold;
}

.imagen {
    height: 3px;
    width: 6px;
    margin: auto ;
    border: 0.01px solid #ededed;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: right;
}

.details h2{
    font-size: 20px;
    color: #283747;
}

.details h3{
    font-size: 20px;
    color: #283747;
}


.details nav button{
    color: #151b22;
    background: #aeb3b9;
    border: 1px solid #E5E7E9;

    border-radius: 20px;
    padding: 10px 50px;
}

.details nav button:hover{
    color: #151b22;
    background: #75a8db;
    border: 1px solid #28313a;
}

.details {
    border: 0px solid rgba(0, 0, 0, 0.3);
    border-radius: 20px;
    padding: 30px 80px;
    margin: 30px 0 0 0;
    width: 50%;
    height: 50%;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}


</style>