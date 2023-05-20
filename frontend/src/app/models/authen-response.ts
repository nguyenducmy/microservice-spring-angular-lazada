export class AuthenResponse {
  private code: string;
  private object: any;
  private status: string | undefined

  constructor(private res: any) {
    this.code = res.code;
    this.object = res.object.toString();
    this.status = res.status;
  }
  get getJwtToken():string{
    return <string>this.object;
  }
}
