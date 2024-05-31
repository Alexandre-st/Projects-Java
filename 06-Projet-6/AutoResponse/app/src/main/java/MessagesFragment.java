public class MessagesFragment extends Fragment {
  private RecyclerView recyclerView;
  private MessagesAdapter adapter;
  private EditText customMessageEditText;
  private Button addMessageButton;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_messages, container, false);
    recyclerView = view.findViewById(R.id.recyclerViewMessages);
    customMessageEditText = view.findViewById(R.id.customMessageEditText);
    addMessageButton = view.findViewById(R.id.addMessageButton);

    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    adapter = new MessagesAdapter(getMessages());
    recyclerView.setAdapter(adapter);

    addMessageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String message = customMessageEditText.getText().toString();
        if (!message.isEmpty()) {
          adapter.addMessage(new Message(message));
          customMessageEditText.setText("");
        }
      }
    });

    return view;
  }

  private List<Message> getMessages() {
    // Code to fetch predefined messages
    List<String> messageContents = messagesManager.getMessages();
    List<Message> messages = new ArrayList<>();
    for (String content : messageContents) {
      messages.add(new Message(content));
    }
    return messages;
  }
}

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {
  private List<Message> messages;

  public MessagesAdapter(List<Message> messages) {
    this.messages = messages;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Message message = messages.get(position);
    holder.messageContent.setText(message.getContent());
    holder.autoResponseCheckBox.setChecked(message.isAutoResponse());
    holder.spamCheckBox.setChecked(message.isSpam());
  }

  @Override
  public int getItemCount() {
    return messages.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView messageContent;
    public CheckBox autoResponseCheckBox;
    public CheckBox spamCheckBox;

    public ViewHolder(View itemView) {
      super(itemView);
      messageContent = itemView.findViewById(R.id.messageContent);
      autoResponseCheckBox = itemView.findViewById(R.id.autoResponseCheckBox);
      spamCheckBox = itemView.findViewById(R.id.spamCheckBox);
    }
  }

  public void addMessage(Message message) {
    messages.add(message);
    notifyItemInserted(messages.size() - 1);
  }
}
