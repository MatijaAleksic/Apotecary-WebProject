<template>
  <div id="container"><div id="container-inner">
    <h3>Write an answer</h3>
    <form>
      <fieldset>
        <div>
          <input style="width: 500px;
                        height: 200px;
                        padding: 12px 20px;
                        margin: 8px 0;
                        display: inline-block;
                        border: 1px solid #ccc;
                        border-radius: 4px;
                        box-sizing: border-box;"
                 type="text"  id="answer" name="answer" v-model="answer" required />
        </div>
        
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="acceptVacation" value="Accept" />
        </div>

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="declineVacation" value="Decline" />
        </div>

      </fieldset>
    </form>
  </div></div>
</template>

<script>

export default {
  name: 'AnswerToVacation',
  data() {
    return {

      answer : ""
    }
  },

  methods:{

    acceptVacation(){
        this.$emit('close-component', {answer: this.answer, decision: true});
    },

    declineVacation(){
        this.$emit('close-component',  {answer: this.answer, decision: false});
    }
  }

}
</script>