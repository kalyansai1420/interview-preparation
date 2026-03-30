import { useState } from "react";
import { CommentsList } from "./components/CommentsList/CommentsList";
import DebounceSearch from "./components/DebounceSearch/DebounceSearch";
import { FileExplorer } from "./components/FileExplorer/FileExplorer";
import { Modal } from "./components/Modal/Modal";
import { Tabs } from "./components/Tabs/Tabs";

export default function App() {
  // const comments = [
  //   {
  //     id: 1,
  //     text: "Comment 1",
  //     children: [
  //       {
  //         id: 2,
  //         text: "Reply 1",
  //       },
  //     ],
  //   },
  // ];

  
  const initialData = [
    {
      id: 1,
      name: "src",
      isFolder: true,
      children: [
        {
          id: 2, name: "App.js", isFolder: false
        },
        {
          id: 3, name: "components",
          isFolder: true, children: [
            { id:4,name:"Modal.js", isFolder:false}
          ],
        }
      ]
    }
  ]
  const [data,setData] = useState(initialData)

  return (
    <div>
      <h1>Frontend Practice</h1>
      <Tabs />
      {/* <DebounceSearch />
      <Modal />
      <CommentsList comments={comments} /> */}
      <FileExplorer data={data} setData={setData} />
    </div>
  );
}
