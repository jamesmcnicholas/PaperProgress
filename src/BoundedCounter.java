 public class BoundedCounter {

        private int countValue;
        private int upperBound;

        public BoundedCounter(int upperBound){
            this.countValue=0;
            this.upperBound=upperBound;
        }

        public void next(){
            if (this.countValue<upperBound) {
                this.countValue++;
            }else{
                this.countValue=0;
            }
        }

        public String toString(){
            if (this.countValue<10) {
                return "0" + this.countValue;
            }else{
                return "" + this.countValue;
            }
        }

        public int getValue(){
            return this.countValue;
        }

        public void setValue(int value){
            if ((value<=upperBound)&&(value>=0)){
                this.countValue=value;
            }
        }
 }
