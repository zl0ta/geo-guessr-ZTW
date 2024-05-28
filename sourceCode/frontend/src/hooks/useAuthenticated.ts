import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const useAuthenticated = () => {
  const navigate = useNavigate();
  
  const accessToken = localStorage.getItem('accessToken');
  const authenticated = !!accessToken;
  
  useEffect(() => {
    if(!authenticated) {
      navigate('/login');
    }
  }, [authenticated, navigate]);
}

export default useAuthenticated;