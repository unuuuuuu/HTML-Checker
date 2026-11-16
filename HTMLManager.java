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

  public String toString() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < tags.size(); i++) {
      HTMLTag temp = tags.remove();
      result.append(temp.toString().trim());
      tags.add(temp);
    }

    return result.toString();
  }
}
