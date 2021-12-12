<template>
    <div class="information">

        <div class="details">

            <h1>
                ¡Hola
                <span>{{ userDetailById.name }}</span>!
            </h1>
            
            <nav>
                <button v-on:click="loadAccount"> <h2>LISTA DE PROYECTOS</h2> </button>
                <br>
                <button v-on:click="loadAccount"><h3>  GASTOS PERSONALES </h3> </button>
                <br>
                <button v-on:click="loadTransaction"> <h2>CREAR UNIDAD HABITACIONAL</h2> </button>
            </nav>
        
        </div>
       
        <div class = "imagebox">
            <img :src="require('../assets/5947.jpg')" alt="" >
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
    height: auto;

    display:flex;
    flex-direction:row;
    justify-content: center;
    align-items: stretch;
    flex-wrap: wrap;
}

.information h1 {
    font-size: 60px;
    color: #283747;
    font-weight: bold;
    text-align: center;
}

.imagebox {
    height: auto;
    width: 40%;
    margin: auto ;
    justify-content: center;
}

img {
    height: auto;
    width: auto;
    box-shadow: 10px 10px #aeb3b9;
}

.details h2{
    font-size: 20px;
    color: #283747;
}

.details h3{
    font-size: 20px;
    color: #283747;
}

nav {
    display:inline-block;
    flex-grow: 1;
    justify-content: center;
    align-items: center;

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
    width: 40%;
    height: auto;

    align-items: center;
}


</style>