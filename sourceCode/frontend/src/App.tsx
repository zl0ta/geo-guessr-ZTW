import Navbar from '@/components/Navbar.tsx';
import ConfirmCode from '@/routes/ConfirmCode.tsx';
import Game from '@/routes/Game.tsx';
import ErrorPage from '@/error-page.tsx';
import Login from '@/routes/Login.tsx';
import Register from '@/routes/Register.tsx';
import Root from '@/routes/Root.tsx';
import { Route, Routes } from 'react-router-dom';


const App = () => {
  return (
    <>
      <div className={'flex justify-center mt-3'}>
        <Navbar/>
      </div>
      <Routes>
        <Route path="/game" element={<Game/>} errorElement={<ErrorPage/>}/>
        <Route path="/register" element={<Register/>} errorElement={<ErrorPage/>}/>
        <Route path="/confirm" element={<ConfirmCode/>} errorElement={<ErrorPage/>}/>
        <Route path="/login" element={<Login/>} errorElement={<ErrorPage/>}/>
        <Route path="/" element={<Root/>} errorElement={<ErrorPage/>}/>
      </Routes>
    </>
  );
};

export default App;