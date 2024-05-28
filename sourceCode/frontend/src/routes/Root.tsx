
const Root = () => {
  
  const accessToken = localStorage.getItem('accessToken');
  const authenticated = !!accessToken;
  
  return (
    <div className='flex flex-row justify-center mt-40'>
      <p>
        Welcome to the Tic Tac Toe game! {!authenticated && "Please sign in to play the game."}
      </p>
    </div>
  );
};

export default Root;