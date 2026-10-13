# LoginForm Using State Object
```jsx

import { useState } from 'react';

function LoginForm() {
 
  const [state, setState] = useState({
    username: "",
    email: ""
  });

  const handleChange = (evt) => {
    const name = evt.target.id;
    const value = evt.target.value;

    setState({
      ...state,
      [name]: value
    });
  }

  function handleSubmit() {
    alert(state.username + " " + state.password);
  }

  return (
    <>   
      <input type="text" placeholder="username" id="username" value={state.username}  onChange={ handleChange }></input>
      <input type="password" placeholder="password" id="password" value={state.password} onChange={ handleChange }></input>
      <input type="submit" value="Submit" onClick={handleSubmit}></input>
    </>
  );
}
export default LoginForm;
```