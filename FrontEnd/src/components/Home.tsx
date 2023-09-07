import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div>
      <h1 className="text-lg font-medium">Home</h1>
      <p className="text-sm text-slate-500">가장 먼저 보여지는 페이지입니다.</p>
      <ul>
        <li>
          <Link to="/test">About</Link>
        </li>
        <li>
          <Link to="/articles">게시글 목록</Link>
        </li>
      </ul>
    </div>
  );
}
