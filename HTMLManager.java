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

  public void fixHTML() {
    Stack<HTMLTag> openingTags = new Stack<HTMLTag>();
    Queue<HTMLTag> fixedTags = new LinkedList<HTMLTag>();

    while (!tags.isEmpty()) {
      HTMLTag temp = tags.remove();

      if (temp.isSelfClosing()) {
        fixedTags.add(temp);
      } else if (temp.isOpening()) {
        fixedTags.add(temp);
        openingTags.push(temp);
      } else if (temp.isClosing()) {
        for (int i = openingTags.size() - 1; i >= 0; i--) {
          if (openingTags.peek().matches(temp)) {
            break;
          }
          fixedTags.add(openingTags.pop().getMatching());
        }

        if (!openingTags.isEmpty()) {
          fixedTags.add(temp);
          openingTags.pop();
        }
      }
    }
  }
}
