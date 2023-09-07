import { NavLink, Outlet, useNavigate } from "react-router-dom";

const Articles = () => {
  const navigate = useNavigate();

  const goback = () => {
    navigate(-1);
  };
  const gohome = () => {
    navigate("/", { replace: true });
  };
  return (
    <div>
      <Outlet />
      <ul className="p-6 divide-y divide-slate-200">
        <ArticleItem id={1} />
        <ArticleItem id={2} />
        <ArticleItem id={3} />
      </ul>
      <button
        className="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
        onClick={() => goback()}
      >
        뒤로가기
      </button>
      <button
        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
        onClick={() => gohome()}
      >
        홈으로
      </button>
    </div>
  );
};

function ArticleItem({ id }: { id: number }) {
  const activeStyle = {
    color: "green",
    fontSize: 21,
  };

  return (
    <li>
      <NavLink
        to={`/articles/${id}`}
        style={({ isActive }) => (isActive ? activeStyle : undefined)}
      >
        게시글 {id}
      </NavLink>
    </li>
  );
}

export default Articles;
