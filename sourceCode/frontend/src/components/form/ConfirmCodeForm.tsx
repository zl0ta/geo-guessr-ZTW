import { Button } from "@/components/ui/button.tsx";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card.tsx";
import {
  InputOTP,
  InputOTPGroup,
  InputOTPSeparator,
  InputOTPSlot
} from '@/components/ui/input-otp.tsx';
import { zodResolver } from '@hookform/resolvers/zod';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormMessage,
} from "@/components/ui/form.tsx";
import { useForm } from 'react-hook-form';

import { z } from "zod";

const formSchema = z.object({
  code: z.string().length(6)
});

interface ConfirmCodeFormProps {
  onSubmit: (code: string) => void;
}

const ConfirmCodeForm = ({ onSubmit }: ConfirmCodeFormProps) => {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      code: "",
    },
  });
  
  return (
    <div className={'flex justify-center'}>
      <Card className="flex justify-center flex-col w-[450px] my-52">
        <CardHeader>
          <CardTitle>Confirm Email</CardTitle>
          <CardDescription>You need to confirm sign up, a code has been sent to their
            email</CardDescription>
        </CardHeader>
        <Form {...form}>
          <form
            onSubmit={form.handleSubmit((values) => onSubmit(values.code))}>
            <CardContent className='flex items-center'>
                <FormField
                  control={form.control}
                  name="code"
                  render={({ field }) => (
                    <FormItem>
                      <FormControl>
                        <InputOTP maxLength={6} {...field}>
                          <InputOTPGroup>
                            <InputOTPSlot index={0}/>
                            <InputOTPSlot index={1}/>
                            <InputOTPSlot index={2}/>
                          </InputOTPGroup>
                          <InputOTPSeparator/>
                          <InputOTPGroup>
                            <InputOTPSlot index={3}/>
                            <InputOTPSlot index={4}/>
                            <InputOTPSlot index={5}/>
                          </InputOTPGroup>
                        </InputOTP>
                      </FormControl>
                      <FormMessage/>
                    </FormItem>
                  )}
                />
              <Button type={'submit'} disabled={form.watch('code').length != 6} className={'ml-5'}>Confirm</Button>
            </CardContent>
          </form>
        </Form>
      </Card>
    </div>
  );
};


export default ConfirmCodeForm;
