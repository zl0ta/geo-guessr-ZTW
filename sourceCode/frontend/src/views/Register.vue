<template>
    <div>
      <h1>Register</h1>
      <form @submit.prevent="register">
        <div>
          <label for="email">Email:</label>
          <input type="email" v-model="email" required />
        </div>
        <div>
          <label for="password">Password:</label>
          <input type="password" v-model="password" required />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'RegisterPage', // Changed name
    data() {
      return {
        email: '',
        password: ''
      }
    },
    methods: {
      async register() {
        try {
          await axios.post('http://localhost:8080/api/auth/register', {
            email: this.email,
            password: this.password
          });
          alert('Registration successful. Please login.');
          this.$router.push('/login');
        } catch (error) {
          console.error(error);
          alert('Registration failed.');
        }
      }
    }
  }
  </script>
  