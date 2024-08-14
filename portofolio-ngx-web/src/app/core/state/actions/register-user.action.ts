import {createAction, props} from "@ngrx/store";
import {User} from "../../model";

export const REGISTER_USER = 'Register a User';
export const REGISTER_USER_SUCCESS = 'Register a User Success';
export const REGISTER_USER_FAIL = 'Register a User Fail';
export const REGISTER_USER_FINALIZE_SUCCESS = 'Register a User Finalize Success';
export const REGISTER_USER_FINALIZE_FAIL = 'Register a User Finalize Fail';

export const RegisterUser = createAction(
  REGISTER_USER,
  props<User>(),
);

export const RegisterUserSuccess = createAction(
  REGISTER_USER_SUCCESS,
);

export const RegisterUserFail = createAction(
  REGISTER_USER_FAIL,
  props<{error: any}>(),
);

export const RegisterUserFinalizeSuccess = createAction(
  REGISTER_USER_FINALIZE_SUCCESS,
)

export const RegisterUserFinalizeFail = createAction(
  REGISTER_USER_FINALIZE_FAIL,
  props<{error: any}>(),
)
