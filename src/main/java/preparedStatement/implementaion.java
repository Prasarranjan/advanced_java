package preparedStatement;

public class implementaion {
        public static void main(String[] args) {
            preparedStatement.getConnection();
            preparedStatement.saveDetails(9,"soumya ranjan sahu","soumya@gmail.com","balunga",94,false);
           preparedStatement.showDetails();
           preparedStatement. getEmployeebyid("harapriya@gmai.com",56);
            preparedStatement.updateDetails("harapriya satpathy","harapriya@gmail.com","talcher",56,true,3);
            preparedStatement.deletegetemployeebyId(8);
        }
    }

