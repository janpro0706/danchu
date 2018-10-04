// @flow
const PREFIX = 'momuck/login';

// action types
const SET_ID = `${PREFIX}/setId`;
const SET_PASSWORD = `${PREFIX}/setPassword`;
const LOGIN_SUCCEED = `${PREFIX}/loginSucceed`;
const LOGIN_FAIL = `${PREFIX}/loginFail`;
const LOGIN_REQUEST = `${PREFIX}/loginRequest`;

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
function loginReducer(state = {
    id: '',
    password: '',
    isLogined: false,
    isProgressing: false
}, action) {
    switch (action.type) {
        case SET_ID:
            return {
                ...state,
                id: action.id
            };
        case SET_PASSWORD:
            return {
                ...state,
                password: action.password
            };
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
export default loginReducer;