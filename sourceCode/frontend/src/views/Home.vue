import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // Assuming your router setup is in 'router.js'

const app = createApp(App);
app.use(router);
app.mount('#app');

<template>
  <div>
    <h1>Welcome to GeoGuessr Clone</h1>
    <p>Only logged in users can see this page.</p>
  </div>
</template>

<script>
export default {
  name: 'HomePage', // Changed name
  created() {
    const user = localStorage.getItem('user');
    if (!user) {
      this.$router.push('/login');
    }
  }
}
</script>
