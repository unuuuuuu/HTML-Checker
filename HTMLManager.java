import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) {
    if (html == null) {
        throw new IllegalArgumentException("HTML queue is null!");
    }

    tags = new LinkedList<HTMLTag>(html);
  }

  public Queue<HTMLTag> getTags() {
    return tags;
  }
}
