import {Actions, createEffect, ofType} from "@ngrx/effects";
import {UserRestService} from "../../../rest/user.rest.service";
import {
  LOAD_USER,
  LOAD_USER_FAIL,
  LOAD_USER_SUCCESS,
  LoadUserFail,
  LoadUserFinalizeFail,
  LoadUserFinalizeSuccess,
  LoadUserSuccess
} from "../actions/load-user.action";
import {catchError, map, switchMap} from "rxjs";
import {Injectable} from "@angular/core";
import {
  REGISTER_USER,
  REGISTER_USER_FAIL,
  REGISTER_USER_SUCCESS,
  RegisterUserFail,
  RegisterUserFinalizeFail,
  RegisterUserFinalizeSuccess,
  RegisterUserSuccess
} from "../actions/register-user.action";
import {User} from "../../model";

@Injectable()
export class UsersEffects {
  constructor(private actions$: Actions, private usersRestService: UserRestService) {}

  public loadUser$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LOAD_USER),
      switchMap((action: string) =>
          this.usersRestService.loadUser(action).pipe(
            map((user) => LoadUserSuccess(user)),
            catchError((error) => {
              return [LoadUserFail({error})];
            })
          )
      )
    ),
  );

  public loadUserSuccess$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LOAD_USER_SUCCESS),
      map((user) =>
        LoadUserFinalizeSuccess(user),
      ),
    ),
  ) ;

  public loadUserFail$ = createEffect(() =>
    this.actions$.pipe(
      ofType(LOAD_USER_FAIL),
      map((error) => LoadUserFinalizeFail(error)),
    ),
  );

  public registerUser$ = createEffect(() =>
    this.actions$.pipe(
      ofType(REGISTER_USER),
      switchMap((action: User) =>
        this.usersRestService.registerUser(action).pipe(
          map(() => RegisterUserSuccess()),
          catchError((error) => {
            return [RegisterUserFail(error)];
          }),
        ),
      ),
    ),
  );

  public registerUserSuccess$ = createEffect(() =>
    this.actions$.pipe(
      ofType(REGISTER_USER_SUCCESS),
      map(() => RegisterUserFinalizeSuccess()),
    ),
  );

  public registerUserFail$ = createEffect(() =>
    this.actions$.pipe(
      ofType(REGISTER_USER_FAIL),
      map((error) => RegisterUserFinalizeFail(error))
    )
  )

}
