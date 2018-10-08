// @flow
import { combineReducers } from 'redux';

const PREFIX = 'momuck/login';

// action types
const SET_ID = `${PREFIX}/setId`;
const SET_PASSWORD = `${PREFIX}/setPassword`;
const LOGIN_SUCCEED = `${PREFIX}/loginSucceed`;
const LOGIN_FAIL = `${PREFIX}/loginFail`;
const LOGIN_REQUEST = `${PREFIX}/loginRequest`;

// state flow type
type Login = {
    id: string,
    password: string,
    isLogined: boolean,
    isProgressing: boolean
};

// action flow types
type SetIdAction = {
    type: string,
    id: string
};

type SetPasswordAction = {
    type: string,
    password: string
};

// action creators
function setId(id: string) {
    return {
        type: SET_ID,
        id
    };
}

function setPassword(password: string) {
    return {
        type: SET_PASSWORD,
        password
    };
}

function loginSucceed() {
    return {
        type: LOGIN_SUCCEED
    };
}

function loginFail() {
    return {
        type: LOGIN_FAIL
    };
}

function loginRequest() {
    return {
        type: LOGIN_REQUEST
    };
}

// reducer
const initialState = {
    id: '',
    password: '',
    isLogined: false,
    isProgressing: false
};

function id(state: string = '', action: SetIdAction) {
    switch (action.type) {
        case SET_ID:
            return action.id;
        default:
            return state;
    }
}

function password(state: string = '', action: SetPasswordAction) {
    switch (action.type) {
        case SET_PASSWORD:
            return action.password;
        default:
            return state;
    }
}

function request(state: Login = initialState, action: any) {
    switch (action.type) {
        case LOGIN_SUCCEED:
        case LOGIN_FAIL:
        case LOGIN_REQUEST:
        default:
            return state;
    }
}

export {
    setId, setPassword, loginSucceed, loginFail, loginRequest
};
export default combineReducers({
    id,
    password,
    request
});