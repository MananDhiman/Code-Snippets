npx create-react-app <app name here>
Or
npm init react-app <app name here>
npm start

Compulsary files is index.js

App.js
```JavaScript
function App(){
    return(
        <div>
        </div>
    )
}

export default App
```

index.js
```javascript
import React from 'react';
import ReactDOM from 'react-dom';
import `component` from '`components/component`';

ReactDOM.render(<`component`/>, document.getElementById('root'));
```

component
```javascript
import React, { Component } from 'react';

class `component` extends Component {
    state = {
        count: 1
    };

    render() {
        //return <h1>Hello</h1>;
        return (
            <span>{this.state.count}</span>
            <span>{foo()}</span>
            <h1>Hello</h1>
            <button>Button that Does</button>
            </div>
        );
    }

    foo(){
        //return this.state.count;
        const { count } = this.state;
        return count;

    }
}

export default `component`;
```
Uses JSX (JavaScript XML)


