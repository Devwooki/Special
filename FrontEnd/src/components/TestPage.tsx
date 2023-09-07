import { useNavigate } from "react-router-dom";

export default function TestPage() {
  const navigate = useNavigate();

  const goback = () => {
    navigate(-1);
  };
  return (
    <div>
      <h1>소개</h1>
      <p>테스트 이동 페이지야</p>
      <button
        className="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
        onClick={() => goback()}
      >
        뒤로가기
      </button>
    </div>
  );
}
