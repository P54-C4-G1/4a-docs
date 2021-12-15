<template>
    <div class="main-component">
      <router-view  
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>

<!-- 
    <div class="footer">
      <div class="button"> 
        <nav>
           <button v-if="is_auth" v-on:click="loadHome"> <h2> Inicio </h2></button>
        </nav>
      </div>
      <div class="button2">
        <nav>
          <button v-show="is_auth" v-on:click="logOut"> <h2> Salir </h2></button>
         </nav>
      </div>
    </div>
-->
    
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

    loadLogIn: function(){
      this.$router.push({name: "logIn"})
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

  html, body {  
    margin:0px;  
    height:100%;  
  }  

 
  .app {
    margin: 0px;
    padding: 0px;
    border: 0px;
    height: 100%;
    widows: 100%;
  }

  .sidebar {
    margin: 0px;
    padding: 0px;
    border: 0px;
    display: flexbox ;
    width: 55%;
    height:100%;  
    background-color: #6e74ec;
    text-align: center;
  }

  .logo {
    max-width: 60%;
    height: auto;
    padding-bottom: 10%;
    padding-top: 10%;
  }

  .welcome {
    margin: 0px;
    border: 0px;
    color: white;
    padding-top: 10%;
    padding-bottom: 10%;
  }

  .appname {
    margin: 0px;
    padding: 0px;
    border: 0px;
    color: white;
    padding-top: 10%;
    padding-bottom: 10%;
  }
  
</style>
