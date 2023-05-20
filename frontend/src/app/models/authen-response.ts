export class AuthenResponse {

  constructor(
    private code: string,
    private object: Object,
    private status: string
  ) {}
  get getJwtToken():string{
    return <string>this.status;
  }
}
