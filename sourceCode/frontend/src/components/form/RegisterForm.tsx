import { Button } from "@/components/ui/button.tsx";
import {
  Card,
  CardContent,
  CardDescription, CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card.tsx";
import { Input } from "@/components/ui/input.tsx";
import { zodResolver } from '@hookform/resolvers/zod';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form.tsx";
import { useForm } from 'react-hook-form';

import { z } from "zod";

const formSchema = z.object({
  username: z.string().min(2).max(50),
  password: z.string().min(8).max(50),
  email: z.string().email(),
});

interface RegisterFormProps {
  onSubmit: (username: string, email: string, password: string) => void;
}

const RegisterForm = ({ onSubmit }: RegisterFormProps) => {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      username: "",
      password: "",
      email: "",
    },
  });
  
  return (
    <div className={'flex justify-center'}>
      <Card className="w-[450px] my-52">
        <CardHeader>
          <CardTitle>Sign-up</CardTitle>
          <CardDescription>Sign-up in order to play Tic Tac Toe.</CardDescription>
        </CardHeader>
        <Form {...form}>
          <form
            onSubmit={form.handleSubmit((values) => onSubmit(values.username, values.email, values.password))}>
            <CardContent>
              <div className="space-y-5">
                <FormField
                  control={form.control}
                  name="username"
                  render={({ field }) => (
                    <FormItem>
                      <FormLabel>Username</FormLabel>
                      <FormControl>
                        <Input placeholder="injustic" {...field} />
                      </FormControl>
                      <FormMessage/>
                    </FormItem>
                  )}
                />
                <FormField
                  control={form.control}
                  name="password"
                  render={({ field }) => (
                    <FormItem>
                      <FormLabel>Password</FormLabel>
                      <FormControl>
                        <Input type="password"
                               placeholder="password" {...field} />
                      </FormControl>
                      <FormMessage/>
                    </FormItem>
                  )}
                />
              </div>
              <CardFooter className="flex justify-center">
                <div className={'flex items-center space-x-2.5 my-5 mb-0'}>
                  <Button type="submit">Sign-up</Button>
                  <span>
                      Already a member? <a href="/login" className="text-blue-500">Login</a>
                    </span>
                </div>
              </CardFooter>
            </CardContent>
          </form>
        </Form>
      </Card>
    </div>
  );
};

export default RegisterForm;
