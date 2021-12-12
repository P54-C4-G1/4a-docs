<template>
  <div id="app" class="app">

    <div class="header">

      <h1 v-if="!is_auth" v-on:click="loadLogIn"> ¡Bienvenido! </h1>
      <h1 v-if="is_auth" v-on:click="loadLogIn"> APP FINANCIERA </h1>
      
    </div>
    

    <div class="main-component">
    
      <router-view  
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>

    </div>
    

    <div class="footer">
      <div class="button"> 
        <nav>
           <button v-if="!is_auth" v-on:click="loadSignUp" > <h2> Registrarse </h2> </button>
           <button v-if="is_auth" v-on:click="loadHome"> <h2> Inicio </h2></button>
        </nav>
      </div>
      <div class="=button2">
        <nav>
          <button v-if="!is_auth" v-on:click="loadLogIn" > <h1> Iniciar Sesión </h1></button>
          <button v-if="is_auth" v-on:click="logOut"> <h2> Salir </h2></button>
         </nav>
      </div>
    </div>
    
  </div>
</template>




<script>
export default {
  name: 'App',

  computed: {
    is_auth: {
      get: function() {
        return this.$route.meta.requiresAuth;
      },
      set: function() { }
    }
  },

  methods:{

    loadLogIn: function(){
      this.$router.push({name: "logIn"})
    },

    loadSignUp: function(){
      this.$router.push({name: "signUp"})
    },

    completedLogIn: function(data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.loadHome();
    },

    completedSignUp: function(data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },

    loadHome: function() {
      this.$router.push({ name: "home" });
    },

    loadAccount: function () {
      this.$router.push({ name: "account" });
    },

    loadTransaction: function(){
      this.$router.push({ name: "transaction" });
    },

    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.loadLogIn();
    },
  }
}

</script>






<style>

  body{
    margin: 0 0 0 0;
  }

  .header{
    margin: 0%;
    padding: 0;
    width: 100%;
    height: 10vh; 
    min-height: 100px;

    background-color: #eceaea ;
    color:#0c1925  ;

    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .header h1{
    width: 60%;
    text-align: center;
  }

  .header nav {
    height: 100%;
    width: 30%;

    display: flex;
    justify-content: space-around;
    align-items: center;

    font-size: 20px;
  }

  .header nav button{
    color: #E5E7E9;
    background: #283747;
    border: 1px solid #E5E7E9;

    border-radius: 5px;
    padding: 10px 20px;
  }

  .header nav button:hover{
    color: #a9bacc;
    background: #E5E7E9;
    border: 1px solid #28313a;
  }

  .main-component image{
    border: 0px solid  #283747;
    border-radius: 10px;
    width: 50%;
    height: 60%;
    
    display: flex;
    flex-direction: column;
    justify-content: left;
    align-items: flex-end;
  }

  .main-component{
    height: 65vh;
    margin: 0%;
    padding: 0%;

    background: #eceaea ;
  }

 
  .footer{
    margin: 0;
    padding: 0;
    width: 100%;
    height: 20vh;
    min-height: 100px; 

    background-color: #eceaea;
    color: #181e24;

    display: flex;
    justify-content: space-evenly;
    align-items: center;

  }

  .footer h2{
   font-size: 20px;
    color: #283747;
  }

  .footer h1{
    font-size: 20px;
    color: #283747;
    
  }

  .footer nav button{
    color: #151b22;
    background: #aeb3b9;
    border: 1px solid #E5E7E9;

    border-radius: 5px;
    padding: 3px 50px;
    
  }

  .footer nav button:hover{
    color: #151b22;
    background: #75a8db;
    border: 1px solid #28313a;
  }

  
</style>
