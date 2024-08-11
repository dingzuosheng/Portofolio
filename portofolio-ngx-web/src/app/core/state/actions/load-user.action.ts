import {createAction, props} from "@ngrx/store";
import {User} from "../../model";

export const LOAD_USER = 'Load User';
export const LOAD_USER_SUCCESS = 'Load User Success';
export const LOAD_USER_FAIL = 'Load User Fail';
export const LOAD_USER_FINALIZE_SUCCESS = 'Load User Finalize Success';
export const LOAD_USER_FINALIZE_FAIL = 'Load User Finalize Fail';


export const LoadUser = createAction(
  LOAD_USER,
  props<{id: string}>(),
)

export const LoadUserSuccess = createAction(
  LOAD_USER_SUCCESS,
  props<User>(),
)

export const LoadUserFail = createAction(
  LOAD_USER_FAIL,
  props<{error: any}>(),
)

export const LoadUserFinalizeSuccess = createAction(
  LOAD_USER_FINALIZE_SUCCESS,
  props<User>(),
)

export const LoadUserFinalizeFail = createAction(
  LOAD_USER_FINALIZE_FAIL,
  props<{error: any}>(),
)
