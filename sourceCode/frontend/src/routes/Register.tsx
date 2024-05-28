import { signUp } from '@/api/AuthApiClient.ts';
import RegisterForm from '@/components/form/RegisterForm.tsx';
import { useToast } from '@/components/ui/use-toast.ts';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  
  const navigate = useNavigate();
  const { toast } = useToast()
  
  const onSubmit = (username: string, email: string, password: string) => {
    signUp(username, email, password)
      .then(() => navigate('/confirm', { state: {username} }))
      .catch((error: Error) => {
        toast({
          title: "Something went wrong. Please try again",
          description: error.message,
        })
      })
  }
  
  return <RegisterForm onSubmit={onSubmit}/>
};

export default Register;
