import { useParams } from "react-router-dom";

export default function Article() {
  const { id } = useParams();
  return (
    <div>
      <li className="flex py-4 first:pt-0 last:pb-0">게시글 {id}</li>
    </div>
  );
}
