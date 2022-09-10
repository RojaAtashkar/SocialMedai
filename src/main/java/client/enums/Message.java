package client.enums;

public enum Message  {
    SUCCESS("SUCCESS"),
    EMPTY_USERNAME("Username is empty"),
    EMPTY_PASSWORD("Password is empty."),
    EMPTY_REPEATED_PASSWORD("Repeated password is empty."),
    USERID_EXIST("Username already exist."),
    MISMATCH_PASSWORD("Passwords do not match."),
    SHORT_PASSWORD("Password is too short. must at least be 8 chars."),
    LONG_PASSWORD("Passwords can't be longer than 30 characters."),
    NON_ALPHANUMERIC_PASSWORD("Passwords must contain both number and character."),
    NO_FILE("No file has been chosen."),
    NON_NUMERIC_PHONE_NUMBER("Phone Number is not numeric"),
    NON_EXISTENT_USERNAME("Username does not exist."), EMPTY_USERID("User Id is Empty");
    private String message;
    Message(String message)
    {
        this.message = message;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
