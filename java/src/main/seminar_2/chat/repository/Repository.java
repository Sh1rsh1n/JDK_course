


public interface Repository {

  void save(String message);

  String getLastMessage();

  List<String> getAllMessage();
  
}