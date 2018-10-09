// @flow
import { combineReducers } from 'redux';

import { dimmerOn, dimmerOff } from './screenReducer';

const PREFIX = 'momuck/login';

// action types
const SET_ID = `${PREFIX}/setId`;
const SET_PASSWORD = `${PREFIX}/setPassword`;
const LOGIN_SUCCEED = `${PREFIX}/loginSucceed`;
const LOGIN_FAIL = `${PREFIX}/loginFail`;
const LOGIN_REQUEST = `${PREFIX}/loginRequest`;

// state flow type
type Id = string;
type Password = string;
type Request = {
    isLogined: boolean,
    isProgressing: boolean
};

type Login = {
    id: Id,
    password: Password,
    request: Request
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

type TypeAction = {
    type: string
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
    return function(dispatch: any) {
        dispatch({
            type: LOGIN_REQUEST
        });
        dispatch(dimmerOn());

        setTimeout(function() {
            dispatch(loginSucceed());
            dispatch(dimmerOff());
        }, 3000);
    }
}

// reducer
const initialState = {
    id: '',
    password: '',
    request: {
        isLogined: false,
        isProgressing: false
    }
};

function id(state: Id = '', action: SetIdAction) {
    switch (action.type) {
        case SET_ID:
            return action.id;
        default:
            return state;
    }
}

function password(state: Password = '', action: SetPasswordAction) {
    switch (action.type) {
        case SET_PASSWORD:
            return action.password;
        default:
            return state;
    }
}

function request(state: Request = initialState.request, action: TypeAction) {
    switch (action.type) {
        case LOGIN_SUCCEED:
            return {
                ...state,
                isLogined: true,
                isProgressing: false
            };
        case LOGIN_FAIL:
            return {
                ...state,
                isLogined: false,
                isProgressing: false
            };
        case LOGIN_REQUEST:
            return {
                ...state,
                isProgressing: true
            };
        default:
            return state;
    }
}

export {
    setId, setPassword, loginRequest
};
export default combineReducers({
    id,
    password,
    request
});