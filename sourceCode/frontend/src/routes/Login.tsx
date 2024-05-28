import { signIn } from '@/api/AuthApiClient.ts';
import LoginForm from '@/components/form/LoginForm.tsx';
import { useToast } from '@/components/ui/use-toast.ts';
import { useNavigate } from 'react-router-dom';


const Login = () => {
  
  const navigate = useNavigate();
  const { toast } = useToast()
  
  const onSubmit = (username:string, password: string) => {
    signIn(
      username,
      password
    ).then(() => {
      navigate('/game', { state: { username: username } });
    }).catch((error: Error) => {
      toast({
        title: "Something went wrong. Please try again",
        description: error.message,
      })
    })
  };
  
  return <LoginForm onSubmit={onSubmit}/>
};

export default Login;
