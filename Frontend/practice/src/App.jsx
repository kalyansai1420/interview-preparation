import { CommentsList } from "./components/CommentsList/CommentsList";
import DebounceSearch from "./components/DebounceSearch/DebounceSearch";
import { Modal } from "./components/Modal/Modal";
import { Tabs } from "./components/Tabs/Tabs";

export default function App() {
  const comments = [
    {
      id: 1,
      text: "Comment 1",
      children: [
        {
          id: 2,
          text: "Reply 1",
        },
      ],
    },
  ];

  return (
    <div>
      <h1>Frontend Practice</h1>
      <Tabs />
      <DebounceSearch />
      <Modal />
      <CommentsList comments={comments} />
    </div>
  );
}
