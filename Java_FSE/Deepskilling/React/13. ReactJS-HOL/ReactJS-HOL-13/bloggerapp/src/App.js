import "./App.css";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

import {
    books,
    blogs,
    courses
} from "./Data";

function App() {

    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;

    return (

        <div className="container">

            {

                showCourses &&

                <div className="section">

                    <h1>Course Details</h1>

                    <CourseDetails
                        courses={courses}
                    />

                </div>

            }

            {

                showBooks &&

                <div className="section">

                    <h1>Book Details</h1>

                    <BookDetails
                        books={books}
                    />

                </div>

            }

            {

                showBlogs &&

                <div className="section">

                    <h1>Blog Details</h1>

                    <BlogDetails
                        blogs={blogs}
                    />

                </div>

            }

        </div>

    );

}

export default App;